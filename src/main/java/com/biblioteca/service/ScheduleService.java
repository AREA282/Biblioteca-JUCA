package com.biblioteca.service;

import com.biblioteca.helpers.ReturnDate;
import com.biblioteca.model.Ejemplar;
import com.biblioteca.model.Prestamo;
import com.biblioteca.model.Usuario;
import com.biblioteca.repository.PrestamoDao;
import com.biblioteca.repository.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class ScheduleService {

    @Autowired
    private PrestamoDao prestamoDao;
    @Autowired
    private UsuarioDao usuarioDao;

    @Scheduled(fixedDelay = 55000)
    public void penalizarUsuarios(){


        List<Prestamo> prestamos= prestamoDao.findByVencidos();
        if (prestamos.size()>0){
            for (Prestamo p:prestamos){
                Date hoy = new Date();

                List<Ejemplar> ejemplares =p.getEjemplares();
                int diasPenalizado = ejemplares.size();
                diasPenalizado = diasPenalizado*8;

                Usuario usuario= usuarioDao.findByCedula(p.getUsuario().getCedula());
                usuario.setEstado(false);
                if (usuario.getFechaPenalizacion()==null || usuario.getFechaPenalizacion().compareTo(hoy)<0){
                    usuario.setFechaPenalizacion(ReturnDate.addDays(diasPenalizado, new Date()));
                } else {
                    usuario.setFechaPenalizacion(ReturnDate.addDays(diasPenalizado, usuario.getFechaPenalizacion()));
                }

                usuarioDao.save(usuario);

                p.setPenalizado(true);
                prestamoDao.save(p);
            }

        }
    }

    @Scheduled(fixedDelay = 55000)
    public void despenalizarUsuarios(){
        List<Usuario> usuarios = usuarioDao.findByEstado(false);

        for (Usuario u: usuarios) {
            Date date = new Date();

            if(u.getFechaPenalizacion().compareTo(date)<0){
                u.setEstado(true);
                usuarioDao.save(u);
            }

        }

    }


}

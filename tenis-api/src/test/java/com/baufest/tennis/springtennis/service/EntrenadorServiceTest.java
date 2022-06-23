package com.baufest.tennis.springtennis.service;

import com.baufest.tennis.springtennis.dto.EntrenadorDTO;
import com.baufest.tennis.springtennis.dto.JugadorDTO;
import com.baufest.tennis.springtennis.mapper.EntrenadorMapperImpl;
import com.baufest.tennis.springtennis.model.Entrenador;
import com.baufest.tennis.springtennis.model.Jugador;
import com.baufest.tennis.springtennis.repository.EntrenadorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EntrenadorServiceTest {
    private final List<Entrenador> entrenadoresDePrueba = new ArrayList<>();
    private final List<EntrenadorDTO> entrenadoresDTODePrueba = new ArrayList<>();
    private final EntrenadorDTO entrenadorDTOParaAgregar = new EntrenadorDTO();
    private final Entrenador entrenadorParaAgregar = new Entrenador();

    EntrenadorServiceImpl entrenadorService;
    @Mock
    EntrenadorRepository entrenadorRepository;
    @BeforeEach
    public void setUp() {
        entrenadoresDTODePrueba.clear();
        entrenadoresDTODePrueba.add(new EntrenadorDTO());
        entrenadoresDTODePrueba.add(new EntrenadorDTO());
        entrenadoresDTODePrueba.add(new EntrenadorDTO());
        entrenadoresDTODePrueba.get(0).setNombre("Facu");
        entrenadoresDTODePrueba.get(1).setNombre("Dylan");
        entrenadoresDTODePrueba.get(2).setNombre("Bruno");
        entrenadoresDTODePrueba.get(0).setId(1L);
        entrenadoresDTODePrueba.get(1).setId(2L);
        entrenadoresDTODePrueba.get(2).setId(3L);

        entrenadoresDePrueba.clear();
        entrenadoresDePrueba.add(new Entrenador());
        entrenadoresDePrueba.add(new Entrenador());
        entrenadoresDePrueba.add(new Entrenador());
        entrenadoresDePrueba.get(0).setNombre("Facu");
        entrenadoresDePrueba.get(1).setNombre("Dylan");
        entrenadoresDePrueba.get(2).setNombre("Bruno");
        entrenadoresDePrueba.get(0).setId(1L);
        entrenadoresDePrueba.get(1).setId(2L);
        entrenadoresDePrueba.get(2).setId(3L);

        entrenadorDTOParaAgregar.setId(4L);
        entrenadorDTOParaAgregar.setNombre("Lucas");

        entrenadorParaAgregar.setId(4L);
        entrenadorParaAgregar.setNombre("Lucas");

       entrenadorService = new EntrenadorServiceImpl(entrenadorRepository) {
       };

    }

    @Test
    void testListEntrenadores() {
        when(entrenadorRepository.findAll()).thenReturn(entrenadoresDePrueba);
        List<EntrenadorDTO> entrenadoresConseguidos = entrenadorService.listAll();
        assertEquals(entrenadoresDTODePrueba.size(),entrenadoresConseguidos.size());
        verify(entrenadorRepository,times(1)).findAll();
    }

    void testSaveOrUpdate() {
        ArgumentCaptor<Entrenador> argumentCaptor = ArgumentCaptor.forClass(Entrenador.class);
        when(entrenadorRepository.save(argumentCaptor.capture())).thenReturn(entrenadorParaAgregar);
        EntrenadorDTO entrenadorDTO = entrenadorService.save(entrenadorDTOParaAgregar);
        assertEquals(entrenadorDTOParaAgregar.getId(),argumentCaptor.getValue().getId());
        assertEquals(entrenadorParaAgregar.getId(), entrenadorDTO.getId());
        assertEquals(entrenadorParaAgregar.getNombre(), entrenadorDTO.getNombre());
        verify(entrenadorRepository).save(any(Entrenador.class));
    }


}

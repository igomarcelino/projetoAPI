package bootcampSantander.projetoAPI.facade;

import bootcampSantander.projetoAPI.dto.LembretesDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service
public class LembretesFacade {

    private static final Map<Long, LembretesDTO> lembretes = new HashMap<>();

    // Criando o lembrete
    public LembretesDTO criar(LembretesDTO lembretesDTO){
        Long id = lembretes.keySet().size()+1L;
        lembretesDTO.setId(id);
        lembretes.put(id,lembretesDTO);
        return lembretesDTO;
    }

    //atualizando o lembrete
    public LembretesDTO atualiza(LembretesDTO lembretesDTO, Long id){
        lembretes.put(id,lembretesDTO);
        return lembretesDTO;
    }

    // mostrar lembretes
    public List<LembretesDTO> mostrarLembretes(){
        return new ArrayList<>(lembretes.values());
    }

    public String deletarLembrete(Long id){
        lembretes.remove(id);
        return "Lembrete deletado";
    }
}

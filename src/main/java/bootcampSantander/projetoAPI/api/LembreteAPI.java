package bootcampSantander.projetoAPI.api;

import bootcampSantander.projetoAPI.dto.LembretesDTO;
import bootcampSantander.projetoAPI.facade.LembretesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/lembretes",produces = MediaType.APPLICATION_JSON_VALUE)
public class LembreteAPI {

    @Autowired
    private LembretesFacade lembretesFacade ;

    @PostMapping("/{lembreteId}")
    @ResponseBody
    public LembretesDTO criar(@RequestBody LembretesDTO lembretesDTO){
        return lembretesFacade.criar(lembretesDTO);
    }

    @PutMapping("/{lembreteId}")
    @ResponseBody
    public LembretesDTO atualizar(@PathVariable("lembreteId")Long lembreteId,@RequestBody LembretesDTO lembretesDTO){
        return lembretesFacade.atualiza(lembretesDTO,lembreteId);
    }

    @GetMapping
    @ResponseBody
    public List<LembretesDTO> mostrarLembretes(){
        return lembretesFacade.mostrarLembretes();
    }

    @DeleteMapping("/{lembreteId}")
    @ResponseBody
    public String deletar(@PathVariable("lembreteId") Long lembreId){
        return lembretesFacade.deletarLembrete(lembreId);
    }
}

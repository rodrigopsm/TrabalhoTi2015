
package br.unicesumar.restserver.disciplina;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    @Autowired
    private EntityManager em;
    
    @RequestMapping(method= RequestMethod.GET)
    public List<Disciplina> getDisciplinas(){
        return em.createQuery("from Disciplina d").getResultList();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void criarDisciplina(@RequestBody Disciplina d){
        em.persist(d);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void alterarDisciplina(@RequestBody Disciplina d){
        em.persist(d);
    }
    
    @RequestMapping(method = RequestMethod.DELETE)
    public void excluirDisciplina(@PathVariable Long id){
        em.remove(em.find(Disciplina.class, id));
    }
}

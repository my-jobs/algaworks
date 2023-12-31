package com.algaworks.algafood.service;

import com.algaworks.algafood.model.Cliente;
import com.algaworks.algafood.notificacao.NivelUrgencia;
import com.algaworks.algafood.notificacao.Notificador;
import com.algaworks.algafood.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    //@PostConstruct // quando iniciado o container, o init é chamado depois do construtor/constr padrão
    public void init(){
        System.out.println("INIT " + notificador);
    }

    //@PreDestroy // antes de destruir o bean, chama este método
    public void destroy(){
        System.out.println("DESTROY");
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}

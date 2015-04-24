package br.com.armandocouto.controllers;


import br.com.armandocouto.models.Member;
import br.com.armandocouto.repositories.MemberDao;
import br.com.armandocouto.repositories.impl.MemberDaoImpl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MembersResource {

    @GET
    public List<Member> getAll(){
        MemberDao memberDao = new MemberDaoImpl();
        return memberDao.findAll();
    }
}
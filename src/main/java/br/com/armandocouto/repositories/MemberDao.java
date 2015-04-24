package br.com.armandocouto.repositories;

import br.com.armandocouto.models.Member;

import java.util.List;

public interface MemberDao {

    List<Member> findAll();
}
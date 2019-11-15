package com.virtualcodemonkeys.project2.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtualcodemonkeys.project2.models.SuperCharacter;
import com.virtualcodemonkeys.project2.models.SuperGroup;
import com.virtualcodemonkeys.project2.repos.SuperCharacterRepo;
import com.virtualcodemonkeys.project2.repos.SuperGroupRepo;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Query implements GraphQLQueryResolver {
    private SuperCharacterRepo superCharacterRepo;
    private SuperGroupRepo superGroupRepo;
    public Query(SuperCharacterRepo repo,
                 SuperGroupRepo grepo){
            this.superCharacterRepo=repo;
            this.superGroupRepo=grepo;}
    public List<SuperCharacter> characters(){ return superCharacterRepo.getCharacters();}
    public SuperCharacter characterById(String id){
        return superCharacterRepo.getCharacterById(id);
    }
    public List<SuperGroup> groups() {return superGroupRepo.getGroups();}
    public SuperGroup getGroupByName(String name){
        return superGroupRepo.getGroupByName(name);
    }
}

package com.virtualcodemonkeys.project2.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.virtualcodemonkeys.project2.models.Orientation;
import com.virtualcodemonkeys.project2.models.SuperCharacter;
import com.virtualcodemonkeys.project2.models.SuperGroup;
import com.virtualcodemonkeys.project2.repos.SuperCharacterRepo;
import com.virtualcodemonkeys.project2.repos.SuperGroupRepo;

public class Mutation implements GraphQLMutationResolver {
    private SuperCharacterRepo superCharacterRepo;
    private SuperGroupRepo superGroupRepo;
    public Mutation(SuperCharacterRepo repo,SuperGroupRepo grepo){
        this.superCharacterRepo=repo;
        this.superGroupRepo=grepo;
    }
    public SuperCharacter addCharacter(String name, Integer age, String groupName){
        return  superCharacterRepo.addCharacter(name,age,groupName);
    }
    public SuperGroup addGroup(String name, Orientation orientation){
        return superGroupRepo.addGroup(name,orientation);
    }

}

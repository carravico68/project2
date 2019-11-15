package com.virtualcodemonkeys.project2.repos;

import com.virtualcodemonkeys.project2.models.SuperCharacter;
import com.virtualcodemonkeys.project2.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SuperCharacterRepo {
    private SuperGroupRepo groupRepo;
    private List<SuperCharacter> thecharacters=new ArrayList<SuperCharacter>();
    private SuperCharacterRepo(SuperGroupRepo grepo){
        this.groupRepo=grepo;
        seedCharacters();}
    private void seedCharacters(){
        SuperCharacter c1 = SuperCharacter.builder()
                .id("Char1")
                .name("Super Character1")
                .age(33)
                .build();
        SuperCharacter c2 = SuperCharacter.builder()
                .id("Char2")
                .name("Two Is My Name")
                .age(147)
                .build();
        this.thecharacters.add(c1);
        this.thecharacters.add(c2);
    }
    public List<SuperCharacter> getCharacters(){
        return this.thecharacters;
    }
    public SuperCharacter getCharacterById(String id){
        List<SuperCharacter> matched= this.thecharacters.stream()
                .filter(c->(c.getId().equalsIgnoreCase(id)))
                .collect(Collectors.toList());
        if (matched.size()>0){
            return matched.get(0);
        }else{
        return null;}
    }
public SuperCharacter addCharacter(String name, Integer age, String groupName){
    SuperGroup sGroup=null;
        if(groupName!=null && groupName.length()>0){
            sGroup=groupRepo.getGroupByName(groupName);


        }

        SuperCharacter newChar =SuperCharacter.builder()
                .id("Char"+(this.thecharacters.size()+1))
                .name(name)
                .age(age)
                .group(sGroup)
                .build();
        log.info("> Mutation.addCharacter("+name+")");
        this.thecharacters.add(newChar);

        if(sGroup!=null){
            sGroup.addCharacter(newChar);}

        return newChar;
}
}

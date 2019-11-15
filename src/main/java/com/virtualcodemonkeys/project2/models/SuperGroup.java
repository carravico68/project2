package com.virtualcodemonkeys.project2.models;


import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@Builder
public class SuperGroup {
    private String name;
    private Orientation orientation;
    private List<SuperCharacter> members;
    public void addCharacter(SuperCharacter character){
        if (members==null) members=new ArrayList<>();
        if (members != null){members.add(character);}
    }
    public void removeCharacter(SuperCharacter character){
        this.members=this.members.stream()
                .filter(c-> !c.getName().equalsIgnoreCase(character.getName()))
                .collect(Collectors.toList());
    }
}

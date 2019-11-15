package com.virtualcodemonkeys.project2.repos;

import com.virtualcodemonkeys.project2.models.Orientation;
import com.virtualcodemonkeys.project2.models.SuperGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public  class SuperGroupRepo {
    private List<SuperGroup> superGroups=new ArrayList<>();
    public  SuperGroupRepo(){
        seedGroups();}
    public SuperGroup getGroupByName(String name){
        List<SuperGroup> theGroupList=
                this.superGroups.stream()
                .filter(g->(g.getName().equalsIgnoreCase(name)))
                .collect(Collectors.toList());
        if (theGroupList.size()>0){
            return  theGroupList.get(0);
        }else{
        return null;}
    }
    public void seedGroups(){
        SuperGroup g1 =SuperGroup.builder()
                .name("Bad Dudes")
                .orientation(Orientation.VILLAIN)
                .build();
    this.superGroups.add(g1);
    }
    public List<SuperGroup> getGroups(){return this.superGroups;}
    public SuperGroup addGroup (String name, Orientation orientation){
        SuperGroup newGroup =SuperGroup.builder()
                .name(name)
                .orientation(orientation)
                .build();
        this.superGroups.add(newGroup);
        return newGroup;
    }

}

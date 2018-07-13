package ru.bellintegrator.practice.soldier.view;

import io.swagger.annotations.ApiModelProperty;

public class SoldierView {

    @ApiModelProperty(hidden = true)
    public String id;

    public String name;

    public int age;

    @Override
    public String toString() {
        return "{id:" + id + ";name:" + name + ";age" + age + "}";
    }
}
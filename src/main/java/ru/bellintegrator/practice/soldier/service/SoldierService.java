package ru.bellintegrator.practice.soldier.service;

import ru.bellintegrator.practice.soldier.view.SoldierView;

import java.util.List;

/**
 * Сервис
 */
public interface SoldierService {

    /**
     * Добавить нового солдата в БД
     *
     * @param soldier
     */
    void add(SoldierView soldier);

    /**
     * Получить список солдат
     *
     * @return {@Soldier}
     */
    List<SoldierView> soldiers();
}
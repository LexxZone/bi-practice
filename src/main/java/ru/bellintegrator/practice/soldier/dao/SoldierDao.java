package ru.bellintegrator.practice.soldier.dao;

import ru.bellintegrator.practice.soldier.model.Soldier;
import ru.bellintegrator.practice.soldier.model.Soldier;

import java.util.List;

/**
 * DAO для работы с Soldier
 */
public interface SoldierDao {
    /**
     * Получить все объекты Soldier
     *
     * @return
     */
    List<Soldier> all();

    /**
     * Получить Soldier по идентификатору
     *
     * @param id
     * @return
     */
    Soldier loadById(Long id);

    /**
     * Получить Soldier по имени
     *
     * @param name
     * @return
     */
    Soldier loadByName(String name);

    /**
     * Сохранить Soldier
     *
     * @param soldier
     */
    void save(Soldier soldier);
}

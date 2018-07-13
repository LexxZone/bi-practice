package ru.bellintegrator.practice.soldier.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.soldier.dao.SoldierDao;
import ru.bellintegrator.practice.soldier.model.Soldier;
import ru.bellintegrator.practice.soldier.view.SoldierView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * {@inheritDoc}
 */
@Service
public class SoldierServiceImpl implements SoldierService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final SoldierDao dao;

    @Autowired
    public SoldierServiceImpl(SoldierDao dao) {
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void add(SoldierView view) {
        Soldier soldier = new Soldier(view.name, view.age);
        dao.save(soldier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<SoldierView> soldiers() {
        List<Soldier> all = dao.all();

        return all.stream()
                .map(mapSoldier())
                .collect(Collectors.toList());
    }

    private Function<Soldier, SoldierView> mapSoldier() {
        return p -> {
            SoldierView view = new SoldierView();
            view.id = String.valueOf(p.getId());
            view.name = p.getName();
            view.age = p.getAge();

            log.debug(view.toString());

            return view;
        };
    }
}

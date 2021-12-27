package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    @Test
    public void whenAddAndFindThenRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Alex"));
    }

    @Test
    public void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        Role result = store.findById("10");
        assertNull(result);
    }

    @Test
    public void whenAddDuplicateAndFindRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.add(new Role("1", "Maxim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Alex"));
    }

    @Test
    public void whenReplaceThenRoleNameIsMaxim() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.replace("1", new Role("1", "Maxim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Maxim"));
    }

    @Test
    public void whenNoReplaceRoleThenNoChangeRoleName() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.replace("10", new Role("10", "Maxim"));
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Alex"));
    }

    @Test
    public void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.delete("1");
        Role result = store.findById("1");
        assertNull(result);
    }

    @Test
    public void whenNoDeleteRoleThenRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRoleName(), is("Alex"));
    }
}
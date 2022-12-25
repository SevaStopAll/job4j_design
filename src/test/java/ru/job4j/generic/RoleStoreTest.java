package ru.job4j.generic;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRolenameIsCliric() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Cliric"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Cliric");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Fighter"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindRolenameIsCliric() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Cliric"));
        store.add(new Role("1", "Fighter"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Cliric");
    }

    @Test
    void whenReplaceThenUsernameIsAssassin() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Thief"));
        store.replace("1", new Role("1", "Assassin"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Assassin");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRolename() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Paladin"));
        store.replace("10", new Role("10", "Monk"));
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Paladin");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Necromancer"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRolenameIsDruid() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Druid"));
        store.delete("10");
        Role result = store.findById("1");
        assertThat(result.getRolename()).isEqualTo("Druid");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Barbarian"));
        boolean rsl = store.replace("1", new Role("1", "Sorcerer"));
        assertThat(rsl).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Bard"));
        boolean rsl = store.replace("10", new Role("10", "Mage"));
        assertThat(rsl).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Shaman"));
        boolean rsl = store.delete("1");
        assertThat(rsl).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Stranger"));
        boolean rsl = store.delete("2");
        assertThat(rsl).isFalse();
    }

}
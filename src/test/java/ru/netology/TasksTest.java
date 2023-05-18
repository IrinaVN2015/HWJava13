package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testMatchesQueryNotInSubtasks() {
        Epic epic = new Epic(1, new String[]{"Повесить заркало", "Почистить плиту", "Снять шторы"});
        String query = "Повесить шторы";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryNotInSubtasks1() {
        Epic epic = new Epic(1, new String[]{"Повесить заркало", "Почистить плиту", "Снять шторы"});
        String query = "снять шторы"; //с маленькой буквы
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryInSubtasks() {
        Epic epic = new Epic(1, new String[]{"Купить продукты", "Полить цветы"});
        String query = "Полить цветы";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryInTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = "Позвонить родителям";
        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryNotTitle() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = "позвонить родителям"; //с маленькой буквы
        boolean expected = false;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryNotTitle1() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        String query = "Позвонить родитель";// опечатка ("ь" в конце)
        boolean expected = false;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryInMeetingTopic() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Выкатка 3й версии приложения";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryInMeetingProject() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Приложение НетоБанка";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryInMeetingStart() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Во вторник после обеда";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryInMeetingOneWord() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Выкатка";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryNotMeeting() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "Выкатки"; //на конце "и"
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMatchesQueryNotMeetingRegister() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        String query = "ВЫКАТКА"; //верхний регистр
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

}

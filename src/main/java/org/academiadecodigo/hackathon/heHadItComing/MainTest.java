package org.academiadecodigo.hackathon.heHadItComing;

import org.academiadecodigo.hackathon.heHadItComing.persistence.model.User;

public class MainTest {

    public static void main(String[] args) {

        User user = new User();

        user.setFirstName("Pris");
        user.setLastName("Doidona");
        user.setEmail("pris@academiadecodigo.org");
        user.setPhone("962145215");
    }
}

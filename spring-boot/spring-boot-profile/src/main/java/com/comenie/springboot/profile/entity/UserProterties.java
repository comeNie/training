package com.comenie.springboot.profile.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by 波 on 2017/2/17.
 */
@Component
public class UserProterties {
    @Value("${com.comenie.name}")
    private String name;

    @Value("${com.comenie.age}")
    private Integer age;

    @Value("${com.comenie.randomAge}")
    private  Integer randomAge;

    @Value("${com.comenie.randomName}")
    private  String randomName;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRandomAge() {
        return randomAge;
    }

    public void setRandomAge(Integer randomAge) {
        this.randomAge = randomAge;
    }

    public String getRandomName() {
        return randomName;
    }

    public void setRandomName(String randomName) {
        this.randomName = randomName;
    }

    @Override
    public String toString() {
        return "UserProterties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", randomAge=" + randomAge +
                ", randomName=" + randomName +
                '}';
    }

    class TestComponent{
        private String name;
        private String age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "TestComponent{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }
}

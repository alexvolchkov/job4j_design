package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * @author Aleksandr Volchkov
 */
class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotBlank()
                .isNotNull()
                .isNotEmpty();
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .isNotNull()
                .isNotBlank()
                .startsWith("T");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotNull()
                .containsIgnoringCase("cub");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(10, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object")
                .isNotEmpty()
                .endsWith("t");
    }

    @Test
    void checkVertices0() {
        Box box = new Box(0, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isZero()
                .isEven()
                .isGreaterThan(-1)
                .isLessThan(1)
                .isEqualTo(0);
    }

    @Test
    void checkVertices4() {
        Box box = new Box(4, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isEven()
                .isGreaterThan(3)
                .isLessThan(5)
                .isEqualTo(4);
    }

    @Test
    void checkVertices8() {
        Box box = new Box(8, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isEven()
                .isGreaterThan(7)
                .isLessThan(9)
                .isEqualTo(8)
                .isPositive();
    }

    @Test
    void checkVerticesMinus1() {
        Box box = new Box(10, 10);
        int result = box.getNumberOfVertices();
        assertThat(result).isNotZero()
                .isGreaterThan(-2)
                .isLessThan(0)
                .isEqualTo(-1)
                .isNegative();
    }

    @Test
    void isExist() {
        Box box = new Box(4, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void isNotExist() {
        Box box = new Box(10, 10);
        boolean result = box.isExist();
        assertThat(result).isFalse();
    }

    @Test
    void whenVertex0ThenArea50Dot26() {
        Box box = new Box(0, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(50.26d, withPrecision(0.006))
                .isCloseTo(50.26, withPrecision(0.01d))
                .isCloseTo(50.26d, Percentage.withPercentage(1.0d))
                .isGreaterThan(50.26d)
                .isLessThan(50.27d);
    }

    @Test
    void whenVertex4ThenArea6Dot93() {
        Box box = new Box(4, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(6.93d, withPrecision(0.005))
                .isCloseTo(6.93, withPrecision(0.01d))
                .isCloseTo(6.93d, Percentage.withPercentage(1.0d))
                .isGreaterThan(6.92d)
                .isLessThan(6.93d);
    }

    @Test
    void whenVertex8ThenArea24Dot0() {
        Box box = new Box(8, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(24.0d, withPrecision(0.005))
                .isCloseTo(24.0, withPrecision(0.01d))
                .isCloseTo(24.0d, Percentage.withPercentage(1.0d))
                .isGreaterThan(23.99d)
                .isLessThan(24.01d);
    }

    @Test
    void whenVertex10ThenArea0() {
        Box box = new Box(10, 2);
        double result = box.getArea();
        assertThat(result).isEqualTo(0)
                .isZero();
    }
}
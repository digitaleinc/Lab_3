package com.kpilabs;

/**
 * Клас Boat представляє морський човен з різними характеристиками.
 * <p>
 * Цей клас включає п’ять полів: назву, тип, довжину, водотоннаж та кількість екіпажу.
 * Він надає методи доступу до цих полів, а також методи для порівняння об'єктів.
 * </p>
 * <p>
 * Клас реалізує методи {@code equals} та {@code hashCode} для коректного порівняння об'єктів.
 * </p>
 *
 * @version 1.0
 */
public class Boat {

    private String name;
    private String type;
    private double length; // в метрах
    private double displacement; // водотоннаж
    private int crewCapacity; // кількість екіпажу

    /**
     * Конструктор для створення об'єкта Boat з усіма параметрами.
     *
     * @param name назва човна
     * @param type тип човна
     * @param length довжина човна в метрах
     * @param displacement водотоннаж човна
     * @param crewCapacity кількість екіпажу
     */
    public Boat(String name, String type, double length, double displacement, int crewCapacity) {
        this.name = name;
        this.type = type;
        this.length = length;
        this.displacement = displacement;
        this.crewCapacity = crewCapacity;
    }

    /**
     * Отримує назву човна.
     *
     * @return назва човна
     */
    public String getName() {
        return name;
    }

    /**
     * Встановлює назву човна.
     *
     * @param name назва човна
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Отримує тип човна.
     *
     * @return тип човна
     */
    public String getType() {
        return type;
    }

    /**
     * Встановлює тип човна.
     *
     * @param type тип човна
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Отримує довжину човна.
     *
     * @return довжина човна в метрах
     */
    public double getLength() {
        return length;
    }

    /**
     * Встановлює довжину човна.
     *
     * @param length довжина човна в метрах
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Отримує водотоннаж човна.
     *
     * @return водотоннаж човна
     */
    public double getDisplacement() {
        return displacement;
    }

    /**
     * Встановлює водотоннаж човна.
     *
     * @param displacement водотоннаж човна
     */
    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    /**
     * Отримує кількість екіпажу.
     *
     * @return кількість екіпажу
     */
    public int getCrewCapacity() {
        return crewCapacity;
    }

    /**
     * Встановлює кількість екіпажу.
     *
     * @param crewCapacity кількість екіпажу
     */
    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    /**
     * Перевизначений метод {@code toString} для виведення інформації про човен.
     *
     * @return рядок з інформацією про човен
     */
    @Override
    public String toString() {
        return "Boat | Назва: " + name + " Тип: " + type + " Довжина: " + length + " Водотоннаж: " + displacement + " Екіпіж чол.: " + crewCapacity;
    }

    /**
     * Перевизначений метод {@code equals} для порівняння двох об'єктів Boat.
     *
     * @param o об'єкт для порівняння
     * @return {@code true}, якщо об'єкти однакові за всіма полями, інакше {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boat that = (Boat) o;

        if (Double.compare(that.length, length) != 0) return false;
        if (Double.compare(that.displacement, displacement) != 0) return false;
        if (crewCapacity != that.crewCapacity) return false;
        if (!name.equals(that.name)) return false;
        return type.equals(that.type);
    }

    /**
     * Перевизначений метод {@code hashCode} відповідно до {@code equals}.
     *
     * @return хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        int result;
        result = name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + Double.hashCode(length);
        result = 31 * result + Double.hashCode(displacement);
        result = 31 * result + crewCapacity;
        return result;
    }
}

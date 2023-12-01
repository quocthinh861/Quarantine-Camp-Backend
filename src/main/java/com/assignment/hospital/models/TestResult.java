package com.assignment.hospital.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class TestResult {
    @Id
    private long _id;
    private Timestamp _time;
    private String _type;
    private Boolean _result;
    private Integer _cycle_threshold;
    private Integer _blood_oxygen_level; // Using Integer to allow for null values
    private Integer _breaths_per_minute;

    @Override
    public String toString() {
        return "TestingResult{" +
                "_id=" + _id +
                ", _time=" + _time +
                ", _type='" + _type + '\'' +
                ", _result=" + _result +
                ", _cycle_threshold=" + _cycle_threshold +
                ", _blood_oxygen_level=" + _blood_oxygen_level +
                ", _breaths_per_minute=" + _breaths_per_minute +
                '}';
    }
}

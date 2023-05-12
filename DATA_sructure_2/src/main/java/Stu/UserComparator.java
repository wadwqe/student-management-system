package Stu;

import TotalAffair.Affair;

import java.util.Comparator;

public class UserComparator implements Comparator<Affair> {
public int compare(Affair p1, Affair p2) {
        return p1.getStartTime() - p2.getStartTime();
        }
        }
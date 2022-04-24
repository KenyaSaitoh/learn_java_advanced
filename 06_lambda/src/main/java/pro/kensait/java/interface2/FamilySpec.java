package pro.kensait.java.interface2;

import java.util.List;

public interface FamilySpec<T> {
    default boolean isFamily(T target) {
        for (T family : getFamilyList()) {
            if (target.equals(family)) return true;
        }
        return false;
    }

    List<T> getFamilyList();

    void setFamilyList(List<T> familyList);
}
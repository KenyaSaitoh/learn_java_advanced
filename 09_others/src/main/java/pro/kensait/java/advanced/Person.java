package pro.kensait.java.advanced;

import java.io.Serializable;

public record Person (Integer personId,
        String personName,
        Integer age) implements Serializable {
        private static final long serialVersionUID = -6011243720394071084L;
}
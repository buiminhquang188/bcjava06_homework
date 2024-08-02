package org.cybersoft.buoi36.payload.request;

import java.util.List;

public record Department(String name, String description, List<Long> employeeIds) {
}

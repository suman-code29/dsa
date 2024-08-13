package patterns.arrays;

import java.util.*;

public class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            if (parts.length != 2) {
                continue;
            }
            String local = parts[0];
            String domain = parts[1];
            int plusIndex = local.indexOf('+');
            if (plusIndex != -1) {
                local = local.substring(0, plusIndex);
            }
            local = local.replace(".", "");
            result.add(local + "@" + domain);
        }
        return result.size();
    }
}

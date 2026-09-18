public class BankTransactionReferenceGenerator {

    static String normalizeReference(String raw) {
        String reference = raw.trim();
        String bankCode = reference.substring(0, 3).toUpperCase();
        return bankCode + reference.substring(3);
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[")
              .append(reference.substring(0, 3))
              .append("] DATE: ")
              .append(reference.substring(3, 5))
              .append("/")
              .append(reference.substring(5, 7))
              .append("/")
              .append(reference.substring(7, 9))
              .append(" | SEQ: ")
              .append(reference.substring(9));

        return result.toString();
    }

    public static void main(String[] args) {
        String normalized = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(normalized));
    }
}
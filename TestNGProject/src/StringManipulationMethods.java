public class StringManipulationMethods {

    public String returnInitialsInCaps (String str) {
        StringBuilder sb = new StringBuilder();
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
                sb.append(arr[i]).append(" ");
            }

        return  sb.toString().trim();
    }
    public String returnInitials(String data){
        String result = "";
        String[] words = data.split(" ");

        for(String each: words){
            result += each.substring(0,1).toUpperCase();
        }

        return result;
    }
}

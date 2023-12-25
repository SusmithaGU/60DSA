public class FirstBadVersion {
    public static int util(int n) {
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid))
                end = mid - 1;
            else
                start = mid + 1;
        }
        return end + 1;
    }

    static boolean isBadVersion(int n) {
        if (n >= 6)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(util(8));
    }
}

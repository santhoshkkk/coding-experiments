package leetcode.search;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

    private final int badVersion;

    public FirstBadVersion(int badVersion) {
        this.badVersion = badVersion;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion(1702766719);
        System.out.println(firstBadVersion.firstBadVersion(2126753390));
    }

    /* The isBadVersion API is defined in the parent class VersionControl.*/
    public boolean isBadVersion(int version) {
        return this.badVersion <= version;
    }

    public int firstBadVersion(int n) {

        return firstBadVersion(0, n);
    }

    private int firstBadVersion(int start, int end) {

        int badVersion = -1;
        int smallerBadVersion = -1;

        int middle = (start + end) / 2;
        if (isBadVersion(middle)) {
            badVersion = middle;
            if (start != middle) {
                smallerBadVersion = firstBadVersion(start, middle);
                if (smallerBadVersion != -1) {
                    badVersion = smallerBadVersion;
                }
            }
        } else {
            if (middle + 1 <= end) {
                badVersion = firstBadVersion(middle + 1, end);
            }

        }
        return badVersion;
    }
}

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> num1set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> num2set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> copySet = new HashSet<>(num1set);

        num1set.removeAll(num2set);
        num2set.removeAll(copySet);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(num1set));
        result.add(new ArrayList<>(num2set));
        return result;   
    }
}
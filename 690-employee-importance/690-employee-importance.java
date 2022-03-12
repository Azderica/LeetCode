/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int totalImportance = 0;
        Map<Integer, Employee> employeeMap = new LinkedHashMap<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> idQueue = new LinkedList<>();

        for(Employee employee : employees) {
            employeeMap.put(employee.id, employee);
        }

        idQueue.add(id);
        visited.add(id);
        while(!idQueue.isEmpty()) {
            Employee cur = employeeMap.get(idQueue.poll());
            totalImportance += cur.importance;

            for(int subId : cur.subordinates) {
                if(!visited.contains(subId)) {
                    idQueue.add(subId);
                    visited.add(subId);
                }
            }
        }

        return totalImportance;
    }
}
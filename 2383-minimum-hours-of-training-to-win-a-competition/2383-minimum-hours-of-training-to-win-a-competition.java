class Solution {
    // 0 -> n, 상대를 만나서 넘어갈려면 큰 경험과 에너지 필요
    // i 번째 상대를 물리치면 경험치는 증가하나 기력만큼 감소
    // 1시간의 훈련 시간이 끝나면 경험치를 1 증가하거나 초기 에너지 1을 늘릴 수 있음
    // 최소한의 훈련시간은?
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int hours = 0, n = energy.length;

        for(int i = 0; i < n; i++) {
            if(energy[i] >= initialEnergy) {
                hours += energy[i] - initialEnergy + 1;
                initialEnergy += energy[i] - initialEnergy + 1;
            }
            if(experience[i] >= initialExperience) {
                hours += experience[i] - initialExperience + 1;
                initialExperience += experience[i] - initialExperience + 1;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }

        // return result
        return hours;
    }
}
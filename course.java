class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
    sort(boxTypes.begin(), boxTypes.end(), [](const vector<int> &a, const vector<int> &b) {
        return a[1] > b[1];
    });

    int totalUnits = 0;

    for (const auto& box : boxTypes) {
        int Count = box[0];
        int units = box[1];

        int boxes = min(truckSize, Count);
        totalUnits += boxes * units;
        truckSize -= boxes;

        if (truckSize == 0)
            break;
    }

    return totalUnits;
}

};

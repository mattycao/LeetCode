if (points.size() < 3) return points.size();
int result = 0;
unordered_map<double, int> slope_count;
for (int i = 0; i < points.size()-1; i++) {
slope_count.clear();
int samePointNum = 0; // 与i 重合的点
int point_max = 1; // 和i 共线的最大点数
for (int j = i + 1; j < points.size(); j++) {
double slope; // 斜率
if (points[i].x == points[j].x) {
slope = std::numeric_limits<double>::infinity();
if (points[i].y == points[j].y) {
++ samePointNum;
continue;
}
} else {
slope = 1.0 * (points[i].y - points[j].y) /
(points[i].x - points[j].x);
}
int count = 0;
if (slope_count.find(slope) != slope_count.end())
count = ++slope_count[slope];
else {
count = 2;
slope_count[slope] = 2;
}
if (point_max < count) point_max = count;
}
result = max(result, point_max + samePointNum);
}
return result;
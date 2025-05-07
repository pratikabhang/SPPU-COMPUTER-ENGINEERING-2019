#include <iostream>
#include <vector>
#include <omp.h>
#include <limits>
using namespace std;

int main() {
    int n;
    cout << "Enter number of elements: ";
    cin >> n;
    vector<double> arr(n);

    cout << "Enter elements: " << endl;
    for (double &x : arr) {
        cin >> x;
    }

    double min_val = numeric_limits<double>::max();
    double max_val = numeric_limits<double>::lowest();
    double sum = 0.0, avg = 0.0;

    for (int i = 0; i < n; i++) {
        sum += arr[i];
        if (arr[i] < min_val) min_val = arr[i];
        if (arr[i] > max_val) max_val = arr[i];
    }

    avg = sum / n;

    cout << "Minimum: " << min_val << endl;
    cout << "Maximum: " << max_val << endl;
    cout << "Sum: " << sum << endl;
    cout << "Average: " << avg << endl;

    return 0;
}

/*Enter number of elements: 5
Enter elements:
123
45
6
678
98

Minimum: 6
Maximum: 678
Sum: 950
Average: 190*/

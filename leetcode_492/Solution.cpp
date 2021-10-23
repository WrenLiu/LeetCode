vector<int> constructRectangle_leetcode(int area) {

    vector<int> res;
    for (int i = (int)sqrt(area); ; --i) {
        if(area % i == 0){
            res.push_back(area / i);
            res.push_back(i);
            return res;
        }

    }


}

vector<int> constructRectangle(int area) {

    // l >= w
    // l 和 w 差距尽可能小
    vector<int> res;

    int curMinCha = 0x3f3f3f3f;


    int curW = 1 , curL = area;

    for ( curW = 1; curW <= area / curW; ++curW) {

        if(area % curW != 0 ){
            continue;
        }

        curL = area / curW;

        cout << curL << " " << curW << endl;

        if(curL - curW > curMinCha){
            continue;
        }else if(curL - curW == curMinCha){
            res.push_back(curL);
            res.push_back(curW);
        }else {

            curMinCha = curL - curW;
            res.clear();
            res.push_back(curL);
            res.push_back(curW);
        }
    }


    return res;


}

void leetcode_492(){

    int area = 4;
    vector<int> res = constructRectangle_leetcode(area);


    for (int i : res) {
        cout << i << " ";
    }


}
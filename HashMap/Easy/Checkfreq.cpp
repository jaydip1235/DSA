// https://practice.geeksforgeeks.org/problems/check-frequencies4211/1
class Solution{
public:	
	bool sameFreq(string s)
	{
	    // code here 
	    map<char,int> m;
	    int i=0;
	    while(i<s.length()){
	        m[s[i]]++;
	        i++;
	    }
	    set<int> st;
	    int cnt=0;
	    auto it=m.begin();
	    while(it!=m.end()){
	        if(it->second==1) cnt++;
	        st.insert(it->second);
	        it++;
	    }
	    if(st.size()==1){
	        return true;
	    }
	    else if(st.size()==2){
	        auto it1=st.begin(),it2=++st.begin();
	        if(*it1==1 && cnt==1) return true;
	        else if((*it2-*it1)==1) return true;
	        else return false;
	    }
	    else{
	        return false;
	    }
	}
};
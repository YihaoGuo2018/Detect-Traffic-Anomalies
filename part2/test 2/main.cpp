//
//  main.cpp
//  test 2
//
//  Created by 郭益豪 on 2017/10/6.
//  Copyright © 2017年 郭益豪. All rights reserved.
//

//
//  main2.cpp
//  test
//
//  Created by 郭益豪 on 2017/10/5.
//  Copyright © 2017年 郭益豪. All rights reserved.
//




/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 */


using namespace std;

#include <stdio.h>


#include <iostream>
#include<fstream>
#include <String>
#include <sstream>
int main(){
    double save[1000][3];
    int group[1000];
    int oldgroup[1000];
    int leader[100];
    int oldleader[100];
      double distance2[1000][100];
    
    leader[0]=1000;
    
    
    //double distance3[1000][100];
    for (int tmp=0;tmp<100; tmp++) {
        leader[tmp]=tmp*9;
    }
    


    
    
    
    
    
    
    int mp1=0;
    int mp2=0;
    
    
    ifstream inFile2("/Users/guoyihao/Desktop/m1.csv", ios::in);
    string lineStr2;
    
    while (getline(inFile2, lineStr2))
{
        // 打印整行字符串
        cout << lineStr2 << endl;
        // 存成二维表结构
        stringstream ss(lineStr2);
        string str;
        ;
        // 按照逗号分隔
        while (getline(ss, str, ',')){
            save[mp1][mp2]=stoi(str);
            mp2++;
            if(mp2==3){
                mp1++;
                mp2=0;
            }
            cout<<str<<endl;
            
        }
    }
    
    
    
   
    
    
    
    ///////////////
  
    // while (1) {
        
        
        
        
        
        
        
        
        
        
        
        
        for (int mp1=0; mp1<1000; mp1++) {
            for (int mp2=0; mp2<100; mp2++) {
                int mp3=leader[mp2];
                if (mp3!=mp1) {
                    double tmp4=(
                    save[mp3][0]-save[mp1][0])
                    *(save[mp3][0]-save[mp1][0])
                    +(save[mp3][1]-save[mp1][1])
                    *(save[mp3][1]-save[mp1][1])
                    +(save[mp3][2]-save[mp1][2])
                    *(save[mp3][2]-save[mp1][2]);

                    distance2[mp1][mp2]=tmp4;
                    
                }
                if (mp3==mp1) {
                    distance2[mp1][mp2]=0;
                }
            }
        }
        
        for (int mpp1=0; mpp1<1000; mpp1++) {
            double tpp=distance2[mpp1][0];
            int number=0;
            for (int mpp2=0; mpp2<100; mpp2++)
            {
                double tpp2=distance2[mpp1][mpp2];
                if(tpp!=0){
                    if (tpp>tpp2) {
                        tpp=tpp2;
                        number=mpp2;
                    }
                    
                }
            }
            group[mpp1]=number;
        }
        
        int tmp[1000];
        int tmp2[1000];
        
        for (int cmpp1=0; cmpp1<1000; cmpp1++) {
            tmp2[cmpp1]=0;
        }
        for (int cmp1=0;cmp1<100; cmp1++)
        {
            
            for (int cmpp1=0; cmpp1<1000; cmpp1++) {
                tmp[cmpp1]=0;
            }
            for (int cmpp1=0; cmpp1<1000; cmpp1++) {
                tmp2[cmpp1]=0;
            }
            int typ2=0;
            int number=0;
            for (int cmp2=0; cmp2<1000; cmp2++) {
                if (group[cmp2]==cmp1) {
                    tmp[number]=cmp2;
                    number++;
                }
            }
            if (number!=0) {
                
                for (int cmp3=0; cmp3<number; cmp3++) {
                    for (int cmp4=0; cmp4<number; cmp4++) {
                        tmp2[cmp3]+=(save[tmp[cmp3]][0]-save[tmp[cmp4]][0])
                        *(save[tmp[cmp3]][0]-save[tmp[cmp4]][0])
                        +(save[tmp[cmp3]][1]-save[tmp[cmp4]][1])
                        *(save[tmp[cmp3]][1]-save[tmp[cmp4]][1])
                        +(save[tmp[cmp3]][2]-save[tmp[cmp4]][2])
                        *(save[tmp[cmp3]][2]-save[tmp[cmp4]][2]);
                        }
                    int typ=tmp2[0];
                    typ2=0;
                    for (int cmp5=0; cmp5<number; cmp5++) {
                        if(typ>tmp2[cmp5]){
                            typ=cmp5;
                        }
                    }
                    leader[cmp1]=tmp[typ];
                    
                }
                
                
            }
            
            
            
            
//            int tqp=0;
//            for (int tqp1=0; tqp<1000; tqp++) {
//                if(oldgroup[tqp1]!=group[tqp1]){
//                    tqp=1;
//                }
//                
//            }
//            for (int tqp1=0; tqp<100; tqp++) {
//                if(oldleader[tqp1]!=leader[tqp1]){
//                    tqp=1;
//                }
//            }
//            if (tqp==1) {
//                break;
//            }
       // }
        
        
        
        cout<<"adsasda";
        
        
        
    }
    
    
    ofstream outFile;
    outFile.open("/Users/guoyihao/Desktop/ww1.csv", ios::out); // 打开模式可省略
    for (int tmp11=0; tmp11<1000; tmp11++) {
        outFile<<group[tmp11]<<"\n";;
        
        
    }
    outFile<<"\n";
    outFile.close();
    
    ofstream outFile2;
    outFile2.open("/Users/guoyihao/Desktop/ww2.csv", ios::out); // 打开模式可省略
    for (int tmp11=0; tmp11<100; tmp11++) {
        
            outFile2<<leader[tmp11]<<"\n";
        
        
    }
    outFile2<<"\n";
    outFile2.close();
    
    
    
    
    return 1;
}

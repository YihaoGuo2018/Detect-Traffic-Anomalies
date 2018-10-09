//
//  main.cpp
//  test
//
//  Created by 郭益豪 on 2017/10/3.
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
#include <iostream>
#include<fstream>
#include <String>
#include <sstream>


double change(double savew[1000][3],double tmp2[1000][3],double tmp4[1000][3]);

double change2(double saveh[3][96],double bmp2[3][96],double bmp3[3][96]);
double mutiply(double savec[1000][3],double savep[3][96],double tmp[1000][96]);
double mutiply2(double savec[1000][96],double savep[96][3],double tmp[1000][3]);
double mutiply3(double savec[3][1000],double savep[1000][96],double tmp[3][96]);

double  transposition(double tmp[3][96],double tmp2[96][3]);
double transposition2(double tmp[1000][3],double tmp2[3][1000]);

double compare(double save[1000][3],double tmp[1000][3]);
double compare2(double save[3][96],double tmp[3][96]);

int main(){
    
    
    
    int stop=0;
    int stop2=0;
    
    int mp1=0;
    int mp2=0;
    double save[1000][96];
    
    double savew[1000][3];
    double saveh[3][96];
   
    
    double savewo[1000][3];
    double saveho[3][96];
    
    
    double tmp1[96][3];
    double tmp2[1000][3];
    double tmp3[1000][96];
    double tmp4[1000][3];
    
    double bmp1[3][1000];
    double bmp2[3][96];
    double bmp3[3][96];
    
    
    
    
    
    ifstream inFile("/Users/guoyihao/Desktop/data.csv", ios::in);
    string lineStr;
    
    while (getline(inFile, lineStr))
    {
        // 打印整行字符串
        cout << lineStr << endl;
        // 存成二维表结构
        stringstream ss(lineStr);
        string str;
        ;
        // 按照逗号分隔
        while (getline(ss, str, ',')){
            save[mp1][mp2]=stoi(str);
            mp2++;
            if(mp2==96){
                mp1++;
                mp2=0;
            }
            cout<<str<<endl;

        }
    }
 
    
    mp1=0;
    mp2=0;

    
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
            savew[mp1][mp2]=stoi(str);
            mp2++;
            if(mp2==3){
                mp1++;
                mp2=0;
            }
            cout<<str<<endl;
            
        }
    }
    
    
    mp1=0;
    mp2=0;

    
    ifstream inFile3("/Users/guoyihao/Desktop/m2.csv", ios::in);
    string lineStr3;
    
    while (getline(inFile3, lineStr3))
    {
        // 打印整行字符串
        cout << lineStr3 << endl;
        // 存成二维表结构
        stringstream ss(lineStr3);
        string str;
        ;
        // 按照逗号分隔
        while (getline(ss, str, ',')){
            saveh[mp1][mp2]=stoi(str);
            mp2++;
            if(mp2==96){
                mp1++;
                mp2=0;
            }
            cout<<str<<endl;
            
        }
    }
    
    
    for (int n71=0; n71<2000; n71++) {
        
    
    
//    for (int n5=0; n5<1000; n5++) {
//        for (int n6=0; n6<3; n6++) {
//            
//            savewo[n5][n6]=savew[n5][n6];
//        }
//    }
////    
//    for (int n7=0; n7<3; n7++) {
//        for (int n8=0; n8<96; n8++) {
//            saveho[n7][n8]=saveh[n7][n8];
//        }
//    }

    
    
    transposition(saveh,tmp1);
    mutiply2(save, tmp1, tmp2);
    mutiply(savew, saveh, tmp3);
    mutiply2(tmp3, tmp1, tmp4);
    
    
    
//    ofstream outFile;
//    outFile.open("/Users/guoyihao/Desktop/w1.csv", ios::out); // 打开模式可省略
//    for (int tmp11=0; tmp11<1000; tmp11++) {
//        for (int tmp111=0; tmp111<96; tmp111++) {
//            outFile<<tmp3[tmp11][tmp111]<<",";
//        }
//        outFile<<"\n";
//    }
//    outFile.close();
//    
    
    
    
    
    
    
    
    
    
    
    
    transposition2(savew, bmp1);
    mutiply3(bmp1, save, bmp2);
    
//    ofstream outFile;
//    outFile.open("/Users/guoyihao/Desktop/w1.csv", ios::out); // 打开模式可省略
//    for (int tmp11=0; tmp11<3; tmp11++) {
//        for (int tmp111=0; tmp111<1000; tmp111++) {
//            outFile<<bmp1[tmp11][tmp111]<<",";
//        }
//        outFile<<"\n";
//    }
//    outFile.close();
    

    
    mutiply3(bmp1, tmp3, bmp3);
    
    change(savew, tmp2, tmp4);
    change2(saveh,bmp2,bmp3);
        
        for (int tmp133=0; tmp133<1000; tmp133++) {
            for (int tmp143=0; tmp143<3; tmp143++) {
                if(tmp4[tmp133][tmp143]==0)
                    cout<<"dasdasdasdasd";
            }
        }
        for (int tmp134=0; tmp134<3; tmp134++) {
            for (int tmp144=0; tmp144<96; tmp144++) {
                if(bmp3[tmp134][tmp144]==0)
                    cout<<"dasdasdasdasd";
            }
        }
//        if (stop!=1) {
//        change(savew, tmp2, tmp4);
//        stop=compare(savew, savewo);
//    }
//   
//    if (stop2!=1) {
//        change2(saveh,bmp2,bmp3);
//        stop2=compare2(saveh, saveho);
//    }
//    
//    
//    if (stop==1&&stop2==1) {
//        break;
//    }
    
    }
    
        ofstream outFile;
        outFile.open("/Users/guoyihao/Desktop/w1.csv", ios::out); // 打开模式可省略
        for (int tmp11=0; tmp11<1000; tmp11++) {
            for (int tmp111=0; tmp111<3; tmp111++) {
                outFile<<savew[tmp11][tmp111]<<",";
            }
            outFile<<"\n";
        }
        outFile.close();

    ofstream outFile2;
    outFile2.open("/Users/guoyihao/Desktop/w2.csv", ios::out); // 打开模式可省略
    for (int tmp11=0; tmp11<3; tmp11++) {
        for (int tmp111=0; tmp111<96; tmp111++) {
            outFile2<<saveh[tmp11][tmp111]<<",";
        }
        outFile2<<"\n";
    }
    outFile2.close();


    
    return 1;
    
    
}

double change(double savew[1000][3],double tmp2[1000][3],double tmp4[1000][3]){
    for (int n51=0; n51<1000; n51++) {
        for (int n52=0; n52<3; n52++) {
            
            double tmpp3=tmp2[n51][n52]/tmp4[n51][n52];

           
            savew[n51][n52]=tmpp3*savew[n51][n52];
        }
    }
    return 1;
    
    
}


double change2(double saveh[3][96],double bmp2[3][96],double bmp3[3][96]){
    for (int n61=0; n61<3; n61++) {
        for (int n62=0; n62<96; n62++) {
            double tmpp3=bmp2[n61][n62]/bmp3[n61][n62];
            
            
            saveh[n61][n62]=tmpp3*saveh[n61][n62];
        }
    }
    return 1;
    
    
}
   

//1000*3 3*96   1000*96
double mutiply(double savec[1000][3],double savep[3][96],double tmp[1000][96]){
    
 
    
    
    for (int m=0; m<1000; m++) {
        for (int m2=0; m2<96; m2++) {
   
            int wps=0;
            for (int m3=0; m3<3; m3++) {
               wps+=savec[m][m3]*savep[m3][m2];
            }
            if(wps!=0){
                tmp[m][m2]=wps;
            }
            
        }
    }
   return 1;
}


//1000*96  96*3    1000*3


double mutiply2(double savec[1000][96],double savep[96][3],double tmp[1000][3]){
    
    
    
    
    for (int m7=0; m7<1000; m7++) {
        for (int m8=0; m8<3; m8++) {
            
            
            int wps=0;
            
            for (int m9=0; m9<96; m9++)
            {
                wps+=savec[m7][m9]*savep[m9][m8];
            }
            if(wps!=0){
                tmp[m7][m8]=wps;
            }
        }
        
    }
    
    return 1;
}


//3*1000 1000*96 3*96

double mutiply3(double savec[3][1000],double savep[1000][96],double tmp[3][96]){
    
    
    
    for (int m31=0; m31<3; m31++) {
        for (int m26=0; m26<96; m26++) {
  
            int wps=0;
            for (int m32=0; m32<1000; m32++) {
                wps+=savec[m31][m32]*savep[m32][m26];
                

            }
            if (wps!=0) {
                tmp[m31][m26]=wps;
            }
        }
    }
    return 1;
}

//////////////



//1000*96

double  transposition(double tmp[3][96],double tmp2[96][3]){
    for (int m=0; m<3; m++) {
        for (int m2=0; m2<96; m2++) {
            tmp2[m2][m]=tmp[m][m2];
        }
    }
    
    
    return 1;
}

//
//1000*3


double  transposition2(double tmp[1000][3],double tmp2[3][1000]){
    for (int m=0; m<1000; m++) {
        for (int m2=0; m2<3; m2++) {
            tmp2[m2][m]=tmp[m][m2];
        }
    }
    
    
    return 1;
}


//1000*3
//double compare(double save[1000][3],double tmp[1000][3]){
//    for (int m=0; m<1000; m++) {
//        for (int m2=0; m2<3; m2++) {
//            double tmpp=tmp[m][m2]-save[m][m2];
//            tmpp=abs(tmpp);
//            double p1=save[m][m2];
//            double p2=tmpp;
//            double tmppp=p2/p1;
//            if(tmppp>=0.01){
//                return 0;
//            }
//        }
//    }
//    
//    return 1;
//}
////3*96
//int compare2(int save[3][96],int tmp[3][96]){
//    for (int m=0; m<3; m++) {
//        for (int m2=0; m2<96; m2++) {
//            int tmpp=tmp[m][m2]-save[m][m2];
//            tmpp=abs(tmpp);
//            double p1=save[m][m2];
//            double p2=tmpp;
//            double tmppp=p2/p1;
//            if(tmppp>=0.01){
//                return 0;
//            }
//        }
//    }
//    
//    return 1;
//}


            


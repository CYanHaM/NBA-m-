package PO;
import java.io.Serializable;

public class PlayerTechMPO implements Serializable,Cloneable{
	
	/**
	 *ÿ��������Ա����ͳ�� 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name;                         //����
	public String team;                         //����
	public String division;                     //分区
	public String date;
	public String position;                     //λ��
	public int time;                         //�ڳ�ʱ��
	public int shotIn;                       //Ͷ��������
	public int shot;                         //Ͷ��������
	public int threeShotIn;                  //����������
	public int threeShot;                    //���ֳ�����
	public int penaltyShotIn;                //����������
	public int penaltyShot;                  //���������
	public int offensiveRebound;             //ǰ��������
	public int defensiveRebound;             //��������
	public int rebound;                      //��������
	public int secondaryAttack;              //������
	public int steal;                        //������
	public int blockShot;                    //��ñ��
	public int fault;                        //ʧ����
	public int foul;                         //������
	public int score;                        //���˵÷�
	public int ifFirstLineUp;                 //�Ƿ��ȷ�
	public int ifParticipate;                 //�Ƿ����

	//�������������
	public int teamAllTime;                  //ȫ���ϳ�ʱ��
	public int teamOffensiveRebound;                  //ȫ�ӽ�������
	public int teamDefensiveRebound;                //ȫ�ӷ�������
	public int opponentOffensiveRebound;                  //���ֽ�������
	public int opponentDefensiveRebound;                //���ַ�������
	public int teamShotIn;                             //ȫ�ӽ�����
	public double opponentOffensiveNum;                     //���ֽ�������
	public int opponentTwoShot;                     //���ֽ�����������ִ���
	public int teamShot;                          //ȫ�ӳ��ִ���
	public int teamPenaltyShot;                   //ȫ�ӷ������
	public int teamFault;                          //ȫ��ʧ�����    
	public int ifDouble;

	public Object clone() {  
        PlayerTechMPO mpo = null;  
        try{  
            mpo = (PlayerTechMPO)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return mpo;  
    }  
}

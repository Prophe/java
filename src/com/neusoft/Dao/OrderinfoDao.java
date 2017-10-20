package com.neusoft.Dao;

import java.util.List;

import com.neusoft.entity.Orderinfo;
import com.neusoft.entity.PageModel;

public interface OrderinfoDao {
	//��ѯȫ������ 
	public PageModel<Orderinfo> getPageModel(int pageNo,int pagesize) throws DaoException;
	//���ݶ���״̬��ҳ��ѯ
	public PageModel<Orderinfo> getPageModelByS(int pageNo,int pagesize,int orderstatus) throws DaoException;
	//��ѯorderstatus  =1��δ����
	public List<Orderinfo> getweifukuan() ;
	//��ѯorderstatus  =2���Ѹ���
	public List<Orderinfo> getyifukuan() throws DaoException;
	//��ѯorderstatus  =3���ѷ���
	public List<Orderinfo> getyifahuo() throws DaoException;
	//��ѯorderstatus  =4�������
	public List<Orderinfo> getyiwancheng() throws DaoException;
	//ͨ��ID��ѯָ������
	public Orderinfo getByid(int id);
	//ͨ�������Ų�ѯ������Ϣ
	
	
	//ͨ��id�޸�����
	public boolean upOrdByid(Orderinfo order);
	//��������
	public boolean addorder(Orderinfo order);
	//����idɾ��
	public boolean deleOrdByid(int id);
	//����addrinfo(��¼id����ѯ
	public List<Orderinfo> getOrdByaddrinfo(int id);
	}

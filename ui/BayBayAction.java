package ui;

/*�������� ��� ���������� ���������*/
public class BayBayAction implements Action {

	@Override
	public boolean start() {
		Util.println("�� ������ ������!");
		System.exit(1);
		return true;
	}

}

package jfreechart;

public class DefaultAxisEditor extends AxisEditor {

	Axis axis;
	
	

    public DefaultAxisEditor(Axis axis) {
		super();
		this.axis = axis;
	}



	public static DefaultAxisEditor getInstance(Axis axis) {

        if (axis != null) {
            // figure out what type of axis we have and instantiate the
            // appropriate panel
            if (axis instanceof NumberAxis) {
                return new DefaultNumberAxisEditor((NumberAxis) axis);
            }
            if (axis instanceof LogAxis) {
                return new DefaultLogAxisEditor((LogAxis) axis);
            }
            else {
                return new DefaultAxisEditor(axis);
            }
        }
        else {
            return null;
        }

    }
	
	
}

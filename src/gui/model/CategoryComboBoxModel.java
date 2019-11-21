package gui.model;
 
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
 
import entity.Category;
import service.CategoryService;
 
public class CategoryComboBoxModel implements ComboBoxModel<Category>{
 
    public List<Category> cs = new CategoryService().list(); //collect from Database
//    public List<String> cs = new ArrayList<>(); //test
     
    public Category c;
//    public String c;  //test
     
    public CategoryComboBoxModel(){
        if(!cs.isEmpty())
            c=cs.get(0);
//      cs.add("Dining");
//      cs.add("Transportation");
//      cs.add("Living");
//      cs.add("Expense");

    }
     
    //Size of ComboBox
    @Override
    public int getSize() {
        // TODO Auto-generated method stub
         
        return cs.size();
    }
 
    //Obtain appointed unknown data
    @Override
    public Category getElementAt(int index) {
        // TODO Auto-generated method stub
        return cs.get(index);
    }
    //
    @Override
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
         
    }
 
    //The method is called once an item is selected
    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
    }
 
    //Obtain selected data
    @Override
    public Object getSelectedItem() {
        if(!cs.isEmpty())
            return c;
        else
            return null;
 
    }
 
}
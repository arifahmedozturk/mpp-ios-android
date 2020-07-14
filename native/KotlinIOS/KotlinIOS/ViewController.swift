import UIKit
import SharedCode

class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource  {

    @IBOutlet private var submitButton: UIButton!
    @IBOutlet weak var stationPicker: UIPickerView!
    @IBOutlet weak var stationPicker2: UIPickerView!
    
    var station1 : String = ""
    var station2 : String = ""

    let pickerData = ["London Kings Cross", "Peterborough", "York", "Durham", "Newcastle", "Edinburgh"]
    let stationData = ["KGX", "PBO", "YRK", "DHM", "NCL", "EDB"]
    var stations: [String: String] = ["London Kings Cross": "KGX", "Peterborough": "PBO","York" : "YRK", "Durham":"DHM", "Newcastle":"NCL"]

    // Number of columns of data
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    // The number of rows of data
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView == stationPicker{
            return pickerData.count
        }
        else if pickerView == stationPicker2{
            return pickerData.count
        }
        return 1
    }
    
    // The data to return for the row and component (column) that's being passed in
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView == stationPicker{
            return pickerData[row]
        }
        else if pickerView == stationPicker2{
            return pickerData[row]
        }
        return ""
    }
    

    func pickerView(_ pickerView:UIPickerView, didSelectRow row: Int, inComponent component: Int){
        if pickerView == stationPicker {
            station1 = stationData[row]
            self.view.endEditing(false)
        } else if pickerView == stationPicker2{
            station2 = stationData[row]
        }
    }
    
    private let presenter: ApplicationContractPresenter = ApplicationPresenter()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        //presenter.onViewTaken(view: self)
    }
    
    @IBAction func submitClick(_ sender: Any) {
        UIApplication.shared.open(URL(string: "https://www.lner.co.uk/travel-information/travelling-now/live-train-times/depart/" + station1 + "/" + station2 + "/#LiveDepResults")! as URL, options: [:], completionHandler: nil)
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
}


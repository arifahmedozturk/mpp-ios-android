import UIKit
import SharedCode

class ViewController: UIViewController {

    @IBOutlet private var label: UILabel!

    private let presenter: ApplicationContractPresenter = ApplicationPresenter()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        presenter.onViewTaken(view: self)
        let result = presenter.getJourneys(originStation: "KGX", destinationStation: "PBO")
        print(result)
    }
}

extension ViewController: ApplicationContractView {
    func setLabel(text: String) {
        label.text = text
    }
    
    func setJourneys(str: String) {
        print(str)
    }
    
}

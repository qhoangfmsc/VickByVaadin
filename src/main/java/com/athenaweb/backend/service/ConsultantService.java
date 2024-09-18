package com.athenaweb.backend.service;

import com.athenaweb.backend.entity.Consultant;
import com.athenaweb.backend.repository.ConsultantRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantService {
    private final ConsultantRepository repository;

    public ConsultantService(ConsultantRepository repository) {
        this.repository = repository;
    }

    public List<Consultant> findDataList() {
        return repository.findAll();
    }

    @PostConstruct
    public void createMockupData() {
        if (repository.count() == 0) {
            repository.saveAll(List.of(
                    createConsultant(
                            "", // avatarlink
                            "Chưa có mô tả", // description
                            "Cố vấn 17", // displayname
                            "", // investmentphilosophy
                            "", // investmentstyle
                            true, // isactive
                            5, // rating
                            "", // shortinvestmentphilosophy
                            "INVESTMENT_ADVISORY" // type
                    ),
                    createConsultant(
                            "https://image.stockvn.vn/21232f297a57a5a743894a0e4a801fc3/Nguyễn Trần Hưng_50229126046742.jpg", // avatarlink
                            "Phương pháp đầu cơ lựa chọn cổ phiếu được tính toán bằng ROBOT theo các tiêu chí phân tích cung cầu và dòng tiền kết hợp với phân tích kỹ thuật, phân tích cơ bản để quyết định tỷ trọng giải ngân.", // description
                            "Nguyễn Trần Hưng", // displayname
                            "Đầu cơ cổ phiếu khi sóng ngành, sóng thị trường xuất hiện. Tối ưu và hiện thực hoá lợi nhuận, giảm thua lỗ theo cách nhanh nhất có thể", // investmentphilosophy
                            "Đầu cơ cổ phiếu theo sóng dựa vào robot", // investmentstyle
                            true, // isactive
                            4.5, // rating
                            "Đầu cơ cổ phiếu khi sóng ngành, sóng thị trường xuất hiện. Tối ưu và hiện thực hoá lợi nhuận, giảm thua lỗ theo cách nhanh nhất có thể", // shortinvestmentphilosophy
                            "INVESTMENT_ADVISORY" // type
                    ),
                    createConsultant(
                            "https://image.vick.vn/9b698eb3105bd82528f23d0c92dedfc0/nguyenvietvien_12850842683814930.jpg", // avatarlink
                            "Phương pháp dựa vào đường MA20 để tìm điểm vào và điểm ra theo dòng tiền là phương pháp khá đơn giản và hiệu quả. Với tiêu chí khi nào dòng tiền còn ổn định thì còn giữ nhóm cổ phiếu đó. ", // description
                            "Nguyễn Viết Viên", // displayname
                            "Thị Trường luôn đúng. Hãy để Thị Trường định giá cổ phiếu", // investmentphilosophy
                            "Đầu tư theo dòng tiền và tín hiệu MA20", // investmentstyle
                            true, // isactive
                            4.5, // rating
                            "Thị Trường luôn đúng. Hãy để Thị Trường định giá cổ phiếu", // shortinvestmentphilosophy
                            "INVESTMENT_ADVISORY" // type
                    ),
                    createConsultant(
                            "", // avatarlink
                            "&lt;p&gt;Chưa có mô tả&lt;/p&gt;", // description
                            "Nguyễn Hồng Điệp 2", // displayname
                            "Chưa có mô tả", // investmentphilosophy
                            "VIP 2", // investmentstyle
                            true, // isactive
                            5, // rating
                            "Chưa có mô tả", // shortinvestmentphilosophy
                            "INVESTMENT_ADVISORY_VIP" // type
                    )
            ));

        }
    }

    private Consultant createConsultant(
            String avatarlink,
            String description,
            String displayname,
            String investmentphilosophy,
            String investmentstyle,
            Boolean isactive,
            double rating,
            String shortinvestmentphilosophy,
            String type
    ) {
        Consultant consultant = new Consultant();
        consultant.setAvatarlink(avatarlink);
        consultant.setDescription(description);
        consultant.setDisplayname(displayname);
        consultant.setInvestmentphilosophy(investmentphilosophy);
        consultant.setInvestmentstyle(investmentstyle);
        consultant.setIsactive(isactive);
        consultant.setRating(rating);
        consultant.setShortinvestmentphilosophy(shortinvestmentphilosophy);
        consultant.setType(type);
        return consultant;
    }
}

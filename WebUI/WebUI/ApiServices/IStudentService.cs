using System.Collections.Generic;
using System.Threading.Tasks;
using WebUI.Models;

namespace WebUI.ApiServices
{
    public interface IStudentService
    {
        Task<List<StudentVm>> GetAllAsync();

        Task<bool> InsertAsync(InsertVm studentVm);

        Task<bool> EditAsync(string studentId, InsertVm studentVm);

        Task<InsertVm> GetByIdAsync(string studentId);
    }
}
